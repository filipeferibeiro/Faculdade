module Contador_Tipo_2 (input logic clock, reset, output logic [3:0] saida);
	logic posicao;
	always_ff @(posedge clock)
		begin
			if (reset)
				begin
					saida <= 4'd0;
					posicao <= 1'b0;
				end
			else
				begin
					if (posicao == 1'b0)
						if (saida == 4'd15)
							posicao <= 1'b1;
						else
							saida <= saida + 4'd1;
					else if (posicao == 1'b1)
						if (saida == 4'd0)
							posicao <= 1'b0;
						else
							saida <= saida - 4'd1;
				end
		end
endmodule
					