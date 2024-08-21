<footer class="footer">
    <div class="container">
        <div class="row row-cols-3 justify-content-md-center">
            <div class="col-md-3 mb-3">
                <h2>Social</h2>
                <ul class="box">
                    <li><a href="https://www.facebook.com/GrupoColegioMexiquense">Facebook</a></li>
                    <li><a href="https://twitter.com/colegiomexiquen?lang=es">Twitter</a></li>
                    <li><a href="https://www.instagram.com/grupocolegiomexiquense">Instagram</a></li>
                    <li><a href="https://www.youtube.com/user/ColegioMexiquense92">Youtube</a></li>
                    <li><a href="https://www.grupocolegiomexiquense.edu.mx">Sitio Oficial</a></li>
                </ul>
            </div>
            <div class="col-md-3 mb-3">
                <h2>Información</h2>
                <ul class="box h-box">
                    <li><a href="https://www.grupocolegiomexiquense.edu.mx/Colegio/Contacto">Servicio al cliente</a></li>
                </ul>
            </div>
            <div class="col-md-3 mb-3">
                <h2>Legal</h2>
                <ul class="box">
                    <li><a href="policiesprivacy">Politica de privacidad</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="b-footer">
                <p>Todo los derechos reservados son por ©Grupo Colegio Mexiquense </p>
            </div>
        </div>
    </div>
</footer>
<!-------------------------------------------------------------------------------------------------------->
<!-- BUTTON BO UP -->
<a class="gotopbtn" href="home"><i class="fas fa-arrow-up"></i></a>
<!-- BUTTON CONTACT -->
<a class="btnContact" href="contact"><i class="fas fa-question-circle"></i></a>
<!-- SOCIAL BAR -->
<?php if (!isset($_SESSION['user'])) : ?>
    <section class="social">
        <ul>
            <li><a href="https://www.facebook.com/GrupoColegioMexiquense" class="icon-facebook"><i class="fab fa-facebook-f"></i></a>
            </li>
            <li><a href="https://www.instagram.com/grupocolegiomexiquense" class="icon-instagram"><i class="fab fa-instagram"></i></a>
            </li>
            <li><a href="ttps://twitter.com/colegiomexiquen?lang=es" class="icon-twitter"><i class="fab fa-twitter"></i></a></li>
            <li><a href="https://www.youtube.com/user/ColegioMexiquense92" class="icon-youtube"><i class="fab fa-youtube"></i></a>
            </li>
        </ul>
    </section>
<?php endif; ?>
<!-------------------------------------------------------------------------------------------------------->

<script src="<?php echo JS . 'main.js'; ?>"></script>


</body>

</html>