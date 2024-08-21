<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos</title>
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
            <label><strong>Fecha de nacimiento</strong>: <?php echo $_POST["birthday1"]; ?></label>
        </div>
        <div class="boxShadow">
            <h3>Datos Familiares</h3>
            <label><strong>Nombre</strong>: <?php echo $_POST["name2"]; ?></label> <br>
            <label><strong>Apellidos</strong>: <?php echo $_POST["lastname2"]; ?></label> <br>
            <label><strong>Dirección</strong>: <?php echo $_POST["address2"]; ?></label> <br>
            <label><strong>Correo electrónico</strong>: <?php echo $_POST["email"]; ?></label> <br>
            <label><strong>Telefono</strong>: <?php echo $_POST["phone"]; ?></label> <br>
            <label><strong>Fecha de nacimiento</strong>: <?php echo $_POST["birthday2"]; ?></label>
        </div>

        <div style="text-align: center">
            <a href="index.php" class="btn btn-primary">Reiniciar</a>
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