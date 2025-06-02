.include "configuration.inc"
.include "inter.inc"

@Programa que enciende una led roja, otra amarilla y otra verde

	ldr r0, =GPBASE
	ldr r1,=0xE000D00		@roja,amarilla,verde uno de cada
	str r1,[r0,#GPSET0]		@turn on

end : b end





