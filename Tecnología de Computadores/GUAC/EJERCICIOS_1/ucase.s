.data
cadena: .asciz "Esto es una prueba"

.text
main: 	push {lr}
		ldr a1,=cadena
		bl ucase
		mov a1,#0
		pop {lr}
		mov pc, lr

ucase: 
		ldr r1,[a1]
		cmp r1,#0
		bxeq lr
		cmp r1,#97
		subge r1,r1,#32
		strgeb r1,[a1]
		add a1,a1,#1
		b ucase