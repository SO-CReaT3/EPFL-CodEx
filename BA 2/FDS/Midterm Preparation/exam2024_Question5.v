module mux4to1(
    input w, z,
    input i1, i2, i3,
    output reg f);
    
    wire [1:0] sin = {z, w};

    always @(*) begin
        case (sin)
            2'b00: f = i1;
            2'b01: f = i2;
            2'b10: f = i3;
            2'b11: f = 1;
            default: f = 0;
        endcase
    end
endmodule

module global_circuit(
    input a, b, c,
    input w, z,
    output f);

    wire i1 = ~(a | b);
    wire i2 = b & c;
    wire i3 = a | c;

    mux4to1 poop (.w(w), .z(z), .i1(i1), .i2(i2), .i3(i3), .f(f));
endmodule