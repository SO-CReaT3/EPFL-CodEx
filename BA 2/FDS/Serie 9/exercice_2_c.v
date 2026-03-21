module full_adder1 (
    input x,
    input y,
    input Cin,

    output s,
    output Cout
);

    wire w1, w2, w3;

    // First Half-Adder
    xor XOR1 (w1, x, y);
    and AND1 (w2, x, y);

    // Second Half-Adder
    xor XOR2 (s, Cin, w1);
    and AND2 (w3, Cin, w1);

    or OR1 (Cout, w3, w2);

endmodule


module half_adder (
    output s,
    output Cout,
    
    input x,
    input y
);
    xor (s, x, y);
    and (Cout, x, y);
endmodule


module full_adder2 (
    input x,
    input y,
    input Cin,

    output s,
    output Cout
);
    wire w1, w2, w3;

    half_adder HA1 (w1, w2, x, y);
    half_adder HA2 (s, w3, Cin, w1);

    or OR1 (Cout, w3, w2);
endmodule