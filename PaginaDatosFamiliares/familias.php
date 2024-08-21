<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Datos Familiares</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  <link rel="stylesheet" href="assets/estilos.css" />
</head>

<body>

  <?php if (isset($_POST["name1"])) : ?>
    <div class="boxShadow">
      <h3>Datos Personales</h3>
      <label><strong>Nombre</strong>: <?php echo $_POST["name1"]; ?></label> <br>
      <label><strong>Apellidos</strong>: <?php echo $_POST["lastname1"]; ?></label> <br>
      <label><strong>Dirección</strong>: <?php echo $_POST["address1"]; ?></label> <br>
      <label><strong>Fecha de nacimiento</strong>: <?php echo $_POST["birthday1"]; ?></label> <br>
    </div>
    <div class="boxShadow">
      <h3>Datos Familiares</h3>
      <form class="row g-3" action="<?php echo htmlspecialchars('./resultado.php'); ?>" method="POST">
        <input type="text" hidden name="name1" value="<?php echo $_POST["name1"]; ?>">
        <input type="text" hidden name="lastname1" value="<?php echo $_POST["lastname1"]; ?>">
        <input type="text" hidden name="address1" value="<?php echo $_POST["address1"]; ?>">
        <input type="text" hidden name="birthday1" value="<?php echo $_POST["birthday1"]; ?>">

        <div class="col-6">
          <label for="name" class="form-label">Nombre</label>
          <input type="name" class="form-control" name="name2" id="name" pattern="[a-zA-Z áéíóúÁÉÍÓÚ]{1,15}" required />
        </div>
        <div class="col-6">
          <label for="lastname" class="form-label">Apellidos</label>
          <input type="name" class="form-control" name="lastname2" id="lastname" pattern="[a-zA-Z áéíóúÁÉÍÓÚ]{1,15}" required />
        </div>
        <div class="col-6">
          <label for="inputEmail" class="form-label">Correo electrónico</label>
          <input type="text" class="form-control" name="email" id="inputEmail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required />
        </div>
        <div class="col-6">
          <label for="inputPhone" class="form-label">Telefono</label>
          <input type="phone" class="form-control" name="phone" id="inputPhone" pattern="[0-9]{10}" required />
        </div>
        <div class="col-12">
          <label for="birthday" class="form-label">Fecha de nacimiento</label>
          <input type="date" class="form-control" name="birthday2" id="birthday" required />
        </div>
        <div class="col-12">
          <label for="inputAddress" class="form-label">Dirección</label>
          <input type="text" class="form-control" name="address2" id="inputAddress" pattern="[0-9A-Za-z ,.()#]{1,50}" required />
        </div>
        <button type="submit" class="btn btn-primary">Aceptar</button>
      </form>
    </div>
  <?php else : ?>
    <div class="boxShadow">
      <h3 style="text-align: center">No se recibieron datos</h3>
    </div>
  <?php endif;  ?>

  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>

</html>