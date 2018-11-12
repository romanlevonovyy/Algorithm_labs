class Screen:
    def __init__(self, height, width, maker, type):
        self.height = height
        self.width = width
        self.maker = maker
        self.type = type


    def __str__(self):
        return "Height: " + str(self.height) + ", Width: " + (self.width) + ", Maker: " + str(self.maker)+ ", Type: " + (self.type)
