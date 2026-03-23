module bin_decoder_3to8 (
    input [2:0] in,
    output reg [7:0] out
);
    always @* begin
        case (in)
            'b000: out = 8'b1;
            'b001: out = 8'b10;
            'b010: out = 8'b100;
            'b011: out = 8'b1000;
            'b100: out = 8'b10000;
            'b101: out = 8'b100000;
            'b110: out = 8'b1000000;
            'b111: out = 8'b10000000;
        endcase
    end
endmodule