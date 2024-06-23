


`include "define.v"

//! the decode module
module decode(
        input       [31:0]  Instr_i         ,   //! input instruction
        output      [4:0]   Rs1_o           ,   //! output rs1 reg
        output      [4:0]   Rs2_o           ,   //! output rs2 reg
        output      [4:0]   Rd_o            ,   //! output rd reg
        output  reg [31:0]  IMM_o           ,   //! output IMMnum
        output  reg [2:0]   Branch_o        ,   //! branch part enable
        output  reg         RegWrite_en_o   ,   //! enable to write the reg
        output  reg         MemWrite_en_o   ,   //! enable in save type
        output  reg         Mem2Reg_o       ,
        output  reg [2:0]   MemOP_o         ,
        output      [2:0]   Function3_o     ,   //! output FUNCTION3
        output  reg         ALU_Asrc_o      ,   //! alu RS2 SRC switch(rs2 or imm)
        output  reg [1:0]   ALU_Bsrc_o      ,   //! alu RS2 SRC switch(rs2 or imm)
        output  reg [3:0]   ALUctr_o            //! output ALU operation type

    );

    //! the operation type of instruction
    //! ignore the instruction[1:0]  11 in base instruction op map
    wire    [4:0]       OP_TYPE;
    assign  OP_TYPE = Instr_i[1:0]==2'b11 ? Instr_i[6:2] : 5'b0;

    //! the function3 of instruction
    wire    [2:0]     FUNCTION3;
    assign FUNCTION3 = Instr_i[14:12];
    assign Function3_o = Instr_i[14:12];
    //! the imm of B type
    wire [31:0]     IMM_B_type;
    assign IMM_B_type = {{20{Instr_i[31]}},Instr_i[7],Instr_i[30:25],Instr_i[11:8],1'b0};
    //! the imm of I type
    wire [31:0]     IMM_I_type;
    assign IMM_I_type = {{20{Instr_i[31]}},Instr_i[31:20]};
    //! the imm of S type
    wire [31:0]     IMM_S_type;
    assign IMM_S_type =  {{20{Instr_i[31]}},Instr_i[31:25],Instr_i[11:7]};
    //! the imm of U type
    wire [31:0]     IMM_U_type;
    assign IMM_U_type = {Instr_i[31:12],12'b0};
    //! the imm of J type
    wire [31:0]     IMM_J_type;
    assign IMM_J_type = {{12{Instr_i[31]}},Instr_i[31],Instr_i[19:12],Instr_i[20],Instr_i[30:21],1'b0};
    //! decode instruction register
    assign  Rd_o    =  Instr_i[11:7];
    assign  Rs1_o = Instr_i[19:15];
    assign  Rs2_o   =   Instr_i[24:20];

    //! generate the imm,the control signal and the alu op code
    always @(*) begin
        IMM_o           =   32'hffff_ffff;
        Branch_o        =   `BRANCH_DISABLE;
        RegWrite_en_o   =   `REGWRITE_DISABLE;
        MemWrite_en_o   =   `MEMWRITE_DISABLE;
        MemOP_o         =   3'bx;
        ALU_Asrc_o      =   `ALU_ASRC_REG;
        ALU_Bsrc_o      =   `ALU_BSRC_REG;
        ALUctr_o        =   `ALU_OP_ERR;
        Mem2Reg_o       =   `MEM2REG_DISABLE;
        case (OP_TYPE)
            `LUI: begin
                IMM_o           =   IMM_U_type;
                RegWrite_en_o   =   `REGWRITE_ENABLE;
                ALUctr_o        =   `ALU_OP_LUI;
                ALU_Asrc_o      =   `ALU_ASRC_REG;
                ALU_Bsrc_o      =   `ALU_BSRC_REG;
            end
            `AUIPC: begin
                IMM_o           =   IMM_U_type;
                RegWrite_en_o   =   `REGWRITE_ENABLE;
                ALUctr_o        =   `ALU_OP_ADD;
                ALU_Asrc_o      =   `ALU_ASRC_PC;
                ALU_Bsrc_o      =   `ALU_BSRC_IMM;
            end
            `JAL: begin
                IMM_o           =   IMM_J_type;
                RegWrite_en_o   =   `REGWRITE_ENABLE;
                ALUctr_o        =   `ALU_OP_ADD;
                ALU_Asrc_o      =   `ALU_ASRC_PC;
                ALU_Bsrc_o      =   `ALU_BSRC_4;
                Branch_o        =   `BRANCH_JAL;
            end
            `JALR: begin
                IMM_o           =   IMM_I_type;
                RegWrite_en_o   =   `REGWRITE_ENABLE;
                ALUctr_o        =   `ALU_OP_ADD;
                ALU_Asrc_o      =   `ALU_ASRC_PC;
                ALU_Bsrc_o      =   `ALU_BSRC_4;
                Branch_o        =   `BRANCH_JALR;
            end
            `BRANCHTYPE: begin
                IMM_o           =   IMM_B_type;
                Branch_o        =   FUNCTION3;
                RegWrite_en_o   =   `REGWRITE_DISABLE;
                ALU_Asrc_o      =   `ALU_ASRC_REG;
                ALU_Bsrc_o      =   `ALU_BSRC_REG;
                Mem2Reg_o       =   1'bx;
            end
            `LOADTYPE: begin
                IMM_o           =   IMM_I_type;
                RegWrite_en_o   =   `REGWRITE_ENABLE;
                ALU_Asrc_o      =   `ALU_ASRC_REG;
                ALU_Bsrc_o      =   `ALU_BSRC_REG;
                ALUctr_o        =   `ALU_OP_ADD;
                MemOP_o         =   FUNCTION3;
            end
            `SAVETYPE: begin
                IMM_o           =   IMM_S_type;
                MemWrite_en_o   =   `MEMWRITE_ENABLE;
                ALU_Asrc_o      =   `ALU_ASRC_REG;
                ALU_Bsrc_o      =   `ALU_BSRC_IMM;
                ALUctr_o        =   `ALU_OP_ADD;
                MemOP_o         =   FUNCTION3;
            end
            `OPIMM: begin
                IMM_o        =   IMM_I_type;
                RegWrite_en_o   =   `REGWRITE_ENABLE;
                ALU_Asrc_o      =   `ALU_ASRC_REG;
                ALU_Bsrc_o      =   `ALU_BSRC_IMM;
                case (FUNCTION3)
                    `ADDI3: begin
                        ALUctr_o        =   `ALU_OP_ADD;
                    end
                    `SLTI3: begin
                        ALUctr_o        =   `ALU_OP_SLT;
                    end
                    `SLTIU3: begin
                        ALUctr_o        =   `ALU_OP_SLTU;
                    end
                    `XORI3: begin
                        ALUctr_o        =   `ALU_OP_XOR;
                    end
                    `ORI3: begin
                        ALUctr_o        =   `ALU_OP_OR;
                    end
                    `SLLI3: begin
                        ALUctr_o        =   `ALU_OP_SLL;
                    end
                    `ANDI3: begin
                        ALUctr_o        =   `ALU_OP_AND;
                    end
                    `SRLI3: begin // SRLI SRAI the same function3
                        ALUctr_o        =   (Instr_i[30]) ? `ALU_OP_SRA : `ALU_OP_SRL;
                    end
                    default: begin
                        ALUctr_o        =   `ALU_OP_ERR;
                    end
                endcase
            end
            `OP: begin
                RegWrite_en_o   =   `REGWRITE_ENABLE;
                ALU_Asrc_o      =   `ALU_ASRC_REG;
                ALU_Bsrc_o      =   `ALU_BSRC_REG;
                case (FUNCTION3)
                    `ADD3: begin //add sub same function3
                        ALUctr_o        =   (Instr_i[30]) ? `ALU_OP_SUB : `ALU_OP_ADD;
                    end
                    `SLT3: begin
                        ALUctr_o        =   `ALU_OP_SLT;
                    end
                    `SLTU3: begin
                        ALUctr_o        =   `ALU_OP_SLTU;
                    end
                    `XOR3: begin
                        ALUctr_o        =   `ALU_OP_XOR;
                    end
                    `OR3: begin
                        ALUctr_o        =   `ALU_OP_OR;
                    end
                    `SLL3: begin
                        ALUctr_o        =   `ALU_OP_SLL;
                    end
                    `AND3: begin
                        ALUctr_o        =   `ALU_OP_AND;
                    end
                    `SRL3: begin
                        ALUctr_o        =   `ALU_OP_SRL;
                    end
                    default: begin
                        ALUctr_o        =   `ALU_OP_ADD;
                    end
                endcase
            end
            default: begin
                IMM_o           =   32'hffff_ffff;
                ALUctr_o        =   `ALU_OP_ERR;
            end

        endcase
    end
endmodule


