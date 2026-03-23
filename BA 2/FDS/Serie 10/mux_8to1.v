module mux_8to1 (
    input [2:0] x1, x2, x3, x4, x5, x6, x7, x8,
    input [2:0] s,

    output reg [2:0] f
);
    always @* begin
        case (s)
            'b000: f = x1;
            'b001: f = x2;
            'b010: f = x3;
            'b011: f = x4;
            'b100: f = x5;
            'b101: f = x6;
            'b110: f = x7;
            'b111: f = x8;
        endcase
    end
endmodule