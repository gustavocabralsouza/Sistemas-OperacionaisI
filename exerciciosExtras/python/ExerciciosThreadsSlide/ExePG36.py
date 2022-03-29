import threading
from random import randint
from time import sleep


class Corrida(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.semaforo = threading.Lock()
        self.corredor = 200
        self.velocidade = randint(4, 6)

    @classmethod
    def porta(cls, id):
        print(f"Corredor {id} está cruzando a porta")
        sleep(randint(1, 2))

    def correr(self):
        for i in range(200):
            print(f"Corredor {self.native_id}, falta {self.corredor} metros")
            self.corredor -= self.velocidade
            if self.corredor <= 0:
                break

    def run(self) -> None:
        try:
            self.correr()
            self.semaforo.acquire()
            self.porta(self.native_id)
        except Exception as e:
            print(e)
        finally:
            self.semaforo.release()


if __name__ == '__main__':
    for i in range(1, 5):
        t = Corrida()
        t.start()
        print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
