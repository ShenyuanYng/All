

`include "define.v"

module datamem (
    input             clk_i,
    input      [31:0] Exc_rlt_i,
    input             MemWrite_en_i,
    input      [31:0] Rs2_data_i,
    input      [ 2:0] MemOP_i,
    output reg [31:0] Mem_data_o
);

  reg  [3 : 0] write_op;
  wire [ 31:0] mem_data_raw;
  blk_mem_gen_0 data_ram (
      .clka (clk_i),             // input wire clka
      .wea  (write_op),          // input wire [3 : 0] wea
      .addra(Exc_rlt_i[2+:16]),  // input wire [13 : 0] addra
      .dina (Rs2_data_i),        // input wire [31 : 0] dina
      .douta(mem_data_raw)       //  output wire [31 : 0] douta
  );



  wire [7:0] bytedata;
  wire [15:0] halfdata;
  assign bytedata = mem_data_raw[Exc_rlt_i[1:0]*8+:8];
  assign halfdata = mem_data_raw[Exc_rlt_i[1:0]*8+:16];
  always @(*) begin
      case (MemOP_i)
        `LB3: begin
          Mem_data_o = { {24{bytedata[7]}} ,bytedata};
        end
        `LH3: begin
          Mem_data_o = { {16{halfdata[15]}} ,halfdata};
        end
        `LW3: begin
          Mem_data_o = mem_data_raw;
        end
        `LBU3: begin
          Mem_data_o = {24'b0,bytedata};
        end
        `LHU3: begin
          Mem_data_o = {16'b0,halfdata};
        end
        default: begin
            Mem_data_o = 32'hffff_ffff;  // ebreak
        end
      endcase
  end

  always @(*) begin
    if (MemWrite_en_i) begin  // save type
      case (MemOP_i)
        `SB3: begin
          write_op = 4'b1 << Exc_rlt_i[1:0];
        end
        `SH3: begin
          write_op = 4'b11 << Exc_rlt_i[1:0];
        end
        `SW3: begin
          write_op = 4'b1111 << Exc_rlt_i[1:0];
        end
        default: begin
          write_op = 4'b0;
        end
      endcase
    end
  end


endmodule