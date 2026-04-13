module Excess3Cnt(
    input clk, EN, INIT, LOAD,
    input wire [3:0] CIN,

    output reg [3:0] COUT
);

    reg [3:0] defaultValue = 4'b0011;

    always @ (posedge clk) begin
        if (INIT) COUT = defaultValue;
        else if (LOAD) COUT = CIN + defaultValue;
        else if (EN) begin
            if (COUT == 9 + defaultValue) COUT = defaultValue;
            else COUT = COUT + 1;
        end
    end
endmodule

module TwoDigitCnt(
    input clk,
    input READ, EN, INIT, LOAD,
    input wire [3:0] DIN,

    output reg [3:0] DOUT
);

    reg [3:0] defaultValue = 4'b0011;

    wire EN1 = EN;
    wire EN2 = EN && (DOUT1 == 9 + defaultValue);

    wire [3:0] DOUT1, DOUT2;

    Excess3Cnt units (.clk(clk), .EN(EN1), .INIT(INIT), .LOAD(LOAD), .CIN(DIN), .COUT(DOUT1));
    Excess3Cnt tens (.clk(clk), .EN(EN2), .INIT(INIT), .LOAD(LOAD), .CIN(DIN), .COUT(DOUT2));

    always @(*) begin
        // Asynchronous READ
        if (!READ) DOUT = DOUT1;
        else DOUT = DOUT2;
    end
endmodule