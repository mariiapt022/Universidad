.include "configuration.inc"
.include "inter.inc"

	ldr r0, =GPBASE
	ldr r1,=0xE000D00
	str r1,[r0,#GPSET0]

end : b end