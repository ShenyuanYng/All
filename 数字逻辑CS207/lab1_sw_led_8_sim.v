`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 2021/08/31 09:01:56
// Design Name: 
// Module Name: lab1_sw_led_8_sim
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module lab1_sw_led_8_sim( );
//connect to input
reg [1:0] tb_sw=2'h000000; 
reg [1:0] tb_sw1=2'h0;
//connect to output
wire [2:0] tb_led;
//instantiate the unit 
lab1_sw_led_8 usrc1(
.sw(tb_sw),
.sw1(tb_sw1),
.led(tb_led)
);

always #10 tb_sw=tb_sw+1;
always #10 tb_sw1=tb_sw1+1;
endmodule
