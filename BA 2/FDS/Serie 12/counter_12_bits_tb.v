module counter_12_bits_tb ();
    reg clk;
    wire [11:0] Q;
    integer i;

    counter_12_bits DUT_2 (.clk(clk), .Q(Q));

    initial begin
        $dumpfile("counter_12_bits_tb.vcd");
        $dumpvars(0, counter_12_bits_tb);

        clk = 0;

        #5 $display("Q = 12'b%b", Q);
        for (i = 0; i < 4100; i = i + 1) begin
            #10 $display("Iteration number %d : Q = 12'b%b", i, Q);
        end

        $finish;
    end

    always begin
        #5 clk = ~clk;
    end
endmodule