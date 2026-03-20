module exercice_2_b (
    input a,
    input b,
    input c,

    output f
);

    wire i1, i2, g, h, j;

    not NOT1 (i1, a);
    not NOT2 (i2, b);

    and AND1 (g, i1, b);
    and AND2 (h, i2, c);

    or OR (j, g, h);

    not NOT3 (f, j);
endmodule