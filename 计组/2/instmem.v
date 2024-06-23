


module instmem #(parameter MEMWIDTH = 14)(
        input       [31:0]      PC_i    ,
        output      [31:0]      Instr_o
    );


    (*black_box*)reg [31:0] I_MEM[0:(2**(MEMWIDTH-2)-1)];

    initial begin
        $readmemh("instmem.hex", memory);
    end

    assign Instr_o = I_MEM[PC_i[2+MEMWIDTH:2]];


endmodule
