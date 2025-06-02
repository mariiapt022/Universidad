getwd()

t1=read.table("algoritmo1.csv", header = TRUE, sep = ",")
t2=read.table("algoritmo2.csv", header = TRUE, sep = ",")

#a)
plot(t1,type = "l", col="blue",main="T1 Blue vs T2 Red")
lines(t2,col="red")

plot(t2,type="l",col="red",main="T2 Red vs T1 Blue")
lines(t1,col="blue")

#b)
tam
