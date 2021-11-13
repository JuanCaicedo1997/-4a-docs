from django.db import models
from .user import User

class Account(models.Model):
    id = models.AutoField(primary_key=True)
    user = models.ForeignKey(User, related_name='account', on_delete=models.CASCADE)
    codigo= models.CharField("Código", max_length=30, default="NoCodigo")
    nombreMateria= models.CharField("Nombre de la Materia", max_length=30, default="NoMateria")
    calificacionMateria=models.FloatField(default=0)
    creditosMateria=models.IntegerField(default=0)
   
   
    """ balance = models.IntegerField(default=0)
    lastChangeDate = models.DateTimeField()
    isActive = models.BooleanField(default=True)
    """


