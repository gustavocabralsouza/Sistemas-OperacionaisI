import threading 
from random import randint
import time


class areoporto(threading.Thread):

    def run(self):
        qtd : int = randint(0, 1)
        if qtd == 1 :
            self.Semaphore.acquire()
            self.norte()
            self.Semaphore.release()
        else :
            self.Semaphore.acquire()
            self.sul()
            self.Semaphore.release()

    def __init__(self):
        threading.Thread.__init__(self)
        self.Semaphore = threading.Semaphore()


    def norte(self) :
        print(f'Avião chegando...{self.native_id}')
        self.manobra()
        self.taxiar()
        self.decolagem()
        print(f'Avião saindo...{self.native_id}')
        self.afastamento()

    def sul(self) :
        print(f'Avião chegando...{self.native_id}')
        self.manobra()
        self.taxiar()
        print(f'Avião saindo...{self.native_id}')
        self.decolagem()
        self.afastamento()

    def manobra(self):
        tempo = randint(3, 7)
        time.sleep(tempo)
    
    def taxiar(self):
        tempo = randint(5, 10)
        time.sleep(tempo)
    
    def decolagem(self):
        tempo = randint(1,4)
        time.sleep(tempo)

    def afastamento(self):
        tempo = randint(3, 8)
        time.sleep(tempo)


if __name__ == "__main__":
    for i in range(12):
        t1 = areoporto()
        t1.start()