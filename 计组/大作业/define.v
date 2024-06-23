`timescale 1ns / 1ps


//ignore the instruction[1:0]  11 in base instruction op map
`define LUI           5'b01101
`define AUIPC         5'b00101
`define JAL           5'b11011
`define JALR          5'b11001
//Branch Type
`define BRANCHTYPE    5'b11000
`define BEQ3          3'b000
`define BNE3          3'b001    
`define BLT3          3'b100    
`define BGE3          3'b101
`define BLTU3         3'b110
`define BGEU3         3'b111
//Load Type
`define LOADTYPE      5'b00000
`define LB3           3'b000
`define LH3           3'b001
`define LW3           3'b010
`define LBU3          3'b100
`define LHU3          3'b101
`define LD3           3'b011
`define LWU3          3'b110

//Save Type
`define SAVETYPE      5'b01000
`define SB3           3'b000
`define SH3           3'b001
`define SW3           3'b010
`define SD3           3'b011
//OPIMM
`define OPIMM         5'b00100    
`define ADDI3         3'b000
`define SLTI3         3'b010
`define SLTIU3        3'b011
`define XORI3         3'b100
`define ORI3          3'b110
`define ANDI3         3'b111 
`define SLLI3         3'b001
`define SRLI3         3'b101//attetion function7
`define SRAI3         3'b101//attetion function7
//RV32I Base OP
`define OP            5'b01100
`define ADD3          3'b000//attetion function7
`define SUB3          3'b000//attetion function7
`define SLL3          3'b001
`define SLT3          3'b010
`define SLTU3         3'b011
`define XOR3          3'b100
`define SRL3          3'b101
`define SRA3          3'b101
`define OR3           3'b110
`define AND3          3'b111
//RV32M Standard OP
`define MUL3          3'b000
`define MULH3         3'b001
`define MULHSU3       3'b010
`define MULHU3        3'b011
`define DIV3          3'b100
`define DIVU3         3'b101
`define REM3          3'b110
`define REMU3         3'b111
//RV64I OP32IMM
`define OPIMM32       5'b00110
`define ADDIW3        3'b000
`define SLLIW3        3'b001
`define SRLIW3        3'b101//attetion function7     
`define SRAIW3        3'b101//attetion function7
//RV64I OP32
`define OP32          5'b01110
`define ADDW3         3'b000
`define SUBW3         3'b000
`define SLLW3         3'b001
`define SRLW3         3'b101
`define SRAW3         3'b101
//RV64M Standard
`define MULW3         3'b000
`define DIVW3         3'b100
`define DIVUW3        3'b101
`define REMW3         3'b110
`define REMUW3        3'b111


//alu op code
`define ALU_OP_LUI    4'b0011
//bit operation
`define ALU_OP_XOR    4'b0100
`define ALU_OP_OR     4'b0110
`define ALU_OP_AND    4'b0111
//add
`define ALU_OP_ADD    4'b0000
`define ALU_OP_SUB    4'b1000
//bit shift
`define ALU_OP_SRL    4'b0101
`define ALU_OP_SRA    4'b1101
`define ALU_OP_SLL    4'b0001
//cmp
`define ALU_OP_SLT    4'b0010
`define ALU_OP_SLTU   4'b1010

`define ALU_OP_ERR    4'b1111


`define ALU_ASRC_PC     1'b1
`define ALU_ASRC_REG    1'b0
`define ALU_BSRC_IMM    2'b01
`define ALU_BSRC_REG    2'b00
`define ALU_BSRC_4      2'b10
// `define ALU_
//`define ALU_OP_
`define BRANCH_DISABLE      3'b000
`define BRANCH_JAL          3'b001
`define BRANCH_JALR         3'b010
`define BRANCH_BEQ          3'b100
`define BRANCH_BNE          3'b101
`define BRANCH_BLT          3'b110
`define BRANCH_BGE          3'b111
`define BRANCH_BLTU         3'b110
`define BRANCH_BGEU         3'b111

`define MEMREAD_ENABLE        1'b1
`define MEMREAD_DISABLE       1'b0

`define REGWRITE_ENABLE       1'b1
`define REGWRITE_DISABLE      1'b0

`define MEM2REG_ENABLE        1'b1
`define MEM2REG_DISABLE       1'b0

`define MEMWRITE_ENABLE       1'b1
`define MEMWRITE_DISABLE      1'b0


//  Branch_rlt
`define BRANCH_TRUE           1'b1
`define BRANCH_FALSE          1'b0

