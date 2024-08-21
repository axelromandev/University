<div class="login-overlay" id="login-overlay">
    <div class="login-popup" id="login-popup">
        <div class="login-box">
            <a href="#" id="login-btn-close-popup" class="login-btn-close-popup"><i class="fa fa-times" aria-hidden="true"></i></a>
            <img src="<?php echo IMAGES . 'icono.png'; ?>" class="login-avatar" alt="Avatar Image">
            <h1>Inicio de Sesión</h1>
            <form method="post" class="needs-validation" novalidate>
                <!-- Usuario -->
                <label class="labeluser_login" for="username">Usuario</label>
                <input class="inputuser_login" type="text" name="user" placeholder="Ingresar Usuario" maxlength="50">
                <!-- contraseña -->
                <label class="labelpass_login" for="password">Contraseña</label>
                <input class="inputpass_login" type="password" name="pass" placeholder="Ingresar Contraseña" maxlength="50">
                <input type="submit" name="submitLogin" value="Iniciar Sesión">
                <a href="account/recover-password">¿Olvidaste tu contraseña?</a><br>
                <a id="register-btn-open-popup">¿No tienes una cuenta?</a>
                <?php if (!empty($d->errorLogin)) : ?>
                    <div class="login-error"><?php echo $d->errorLogin; ?></div>
                    <script type="text/javascript" charset="utf-8">
                        document.querySelector('#login-overlay').classList.add('active');
                        document.querySelector('#login-popup').classList.add('active');
                    </script>
                <?php endif; ?>
            </form>
        </div>
    </div>
</div>