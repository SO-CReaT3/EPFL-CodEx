module LFSR_3_bit_tb ();
    reg clk;
    reg [2:0] seed;
    wire [2:0] Q;
    integer i;

    LFSR_3_bit lfsr (.clk(clk), .seed(seed), .Q(Q));

    initial begin
        $dumpfile("LFSR.vcd");
        $dumpvars(0, LFSR_3_bit_tb);

        seed = 3'b001;
        clk = 0;

        #5 $display("0 : Q = 3'b%b", Q);
        for(i = 1; i < 21; i = i + 1) begin
            #10 $display("%d : Q = 3'b%b", i, Q);
        end
        $finish;
    end

    always begin
        #5 clk = ~clk;
    end
endmodule