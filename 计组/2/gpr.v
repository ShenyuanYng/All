

//////////////////////////////////////////////////////////////////////////////////



module gpr(
    input   wire                clk_i,
    input   wire                rst_i,
    input   wire    [4:0]       Rs1_i,
    input   wire    [4:0]       Rs2_i,
    input   wire    [4:0]       Rd_i,
    input   wire    [31:0]      Rd_data_i,
    input                       Rd_wen_i,
    output  wire    [31:0]      Rs1_data_o,
    output  wire    [31:0]      Rs2_data_o

    );

    wire    [31:0]  gpr [31:0];
    wire    [31:1]  gpr_wen;

    // instance of the gpr 
    genvar i;
    generate 
        for (i=0; i<32; i=i+1) begin
        if(i==0) begin
            // assign gpr_wen[0]=0;
            assign gpr[0]=32'b0;
        end else begin
            assign gpr_wen[i] = Rd_wen_i & (Rd_i == i) ;
            register #(32, 32'b0) register (clk_i, rst_i, Rd_data_i, gpr[i], gpr_wen[i]);
        end
        end
    endgenerate

    //connect the output to the gpr
    assign Rs1_data_o = gpr[Rs1_i];
    assign Rs2_data_o = gpr[Rs2_i];
endmodule    
