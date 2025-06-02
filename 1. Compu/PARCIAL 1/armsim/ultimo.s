.data
tam: .word 8
vect: .word 64,25,9,23,56,77,87,100
res: .word 0

.text
.global main
main:	push {lr}
		ldr r0,=vect
		ldr r1,=tam
		ldr r1,[r1]
		ldr r4,=res
		bl maxones
		str r0,[r4]
		pop {pc}
		
ones:	mov r2,#0
	onesloop:
		and r3,r0,#1
		add r2,r2,r3
		lsrs r0,#1
		bne onesloop
		mov r0,r2
		bx lr
maxones: push {lr}
		mov r5,#0
		bucle: cmp r1,#0
		beq salir
		ldr r3,[r0],#4
		push {r0}
		mov r0,r3
		push {r3}
		bl ones
		cmp r0,r5
		pop {r3}
		blt siguiente
		mov r5,r0
		mov r6,r3
		siguiente: 
		pop {r0}
		sub r1,r1,#1
		b bucle
		
		salir:
			pop {lr}
			mov r4,r6
			bx lr
		