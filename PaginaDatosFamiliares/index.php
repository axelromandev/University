<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Informacion</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  <link rel="stylesheet" href="assets/estilos.css" />
</head>

<body>
  <div class="boxShadow">
    <h3>Datos Personales</h3>
    <form class="row g-3" action="<?php echo htmlspecialchars('./familias.php'); ?>" method="POST">
      <div class="col-6">
        <label for="name" class="form-label">Nombre</label>
        <input type="name" class="form-control" name="name1" id="name" pattern="[a-zA-Z áéíóúÁÉÍÓÚ]{1,15}" required />
      </div>
      <div class="col-6">
        <label for="lastname" class="form-label">Apellidos</label>
        <input type="name" class="form-control" name="lastname1" id="lastname" pattern="[a-zA-Z áéíóúÁÉÍÓÚ]{1,15}" required />
      </div>
      <div class="col-12">
        <label for="inputAddress" class="form-label">Dirección</label>
        <input type="text" class="form-control" name="address1" id="inputAddress" pattern="[0-9A-Za-z ,.()#]{1,50}" required />
      </div>
      <div class="col">
        <label for="birthday" class="form-label">Fecha de nacimiento</label>
        <input type="date" class="form-control" name="birthday1" id="birthday" required />
      </div>
      <button type="submit" class="btn btn-primary">Aceptar</button>
    </form>
  </div>


  <script src="assets/index.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>

</html>