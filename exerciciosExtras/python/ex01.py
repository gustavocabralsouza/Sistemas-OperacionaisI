import threading 
import sys
from random import random, randint
import time



class show(threading.Thread):
    qtd_max = 100

    def __init__(self, qtd_ingresso):
        threading.Thread.__init__(self)
        self.qtd = qtd_ingresso
        self.lock = threading.Semaphore()

    def run(self):
        self.login()
        self.lock.acquire()
        self.valid_compra()
        self.lock.release()
        self.compra()

    def login(self):
        print("logando no sistema, por favor aguarde")
        tempo = round(random() * 0.51 + 2, 2)
        time.sleep(tempo)
        if tempo > 3:
            print("tempo esgotado, se ferro")
            sys.exit(0)
    
    def compra(self):
        tempo = round(random() * 1 + 3, 2)
        if tempo > 2.5:
            print("Ops, tempo esgotado, não poderá realizar a compra")
            sys.exit(0)
        time.sleep(tempo)
        

    def valid_compra(self):
        if show.qtd_max > 0:
            show.qtd_max -= self.qtd
            print(f"Ainda existem {show.qtd_max} ingressos disponívis")
        else:
            print("Ops, indisponibilidade dos ingressos, infelizmente não é possível realizar a compra")
            sys.exit(0)


if __name__ == "__main__":
    for i in range(300):
        t1 = show(randint(1, 4))
        t1.start()
