<?php require_once INCLUDES . 'header.php'; ?>

<!-------------------------------MAIN------------------------------------>
<main>
    <section class="publications">
        <div class="container-fluid container-xl">
            <div class="row">
                <div class="col-md-12">
                    <h3>Articulos</h3>
                    <hr>
                </div>
            </div>
            <?php if ($d->posts) : ?>
                <div class="row justify-content-center">
                    <?php foreach ($d->posts as $post) : ?>
                        <div class="col-md-6 col-lg-4 col-xl-4 g-4">
                            <div class="card mb-3 shadow">
                                <a href="publications/single?article=<?php echo $post->id; ?>">
                                    <img src="<?php echo UPLOADS . $post->id_user . '/' . $post->thumb; ?>" class="card-img-top" alt="..." width="100%" height="300">
                                </a>
                                <div class="card-body">
                                    <h5 class="card-title"><?php echo $post->title; ?> </h5>
                                    <p class="card-text"><?php echo $post->description; ?></p>
                                    <a href="publications/single?article=<?php echo $post->id; ?>">Continuar Leyendo</a>
                                    <br><br>
                                    <p class="card-text d-flex justify-content-end">
                                        <small class="text-muted">
                                            <i class="fas fa-eye"></i> <?php echo $post->views; ?> &nbsp
                                            <i class="fas fa-heart"></i> <?php echo $post->likes; ?> &nbsp
                                            <span class="badge bg-dark"><?php echo $post->user; ?></span> &nbsp
                                            <span class="badge bg-secondary"><?php echo getCarrerFilter($post->carrer); ?></span> &nbsp
                                        </small>
                                    </p>
                                </div>
                                <div class="card-footer">
                                    <p class="card-text"><small class="text-muted"><?php echo getDateFilter($post->created_at); ?></small></p>
                                </div>
                            </div>
                        </div>
                    <?php endforeach; ?>
                </div>
            <?php else : ?>
                <div class="row justify-content-center">
                    <div class="col">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="text-center">No hay articulos publicados</h5>
                            </div>
                        </div>
                    </div>
                </div>
            <?php endif; ?>
            <?php require MODULES . 'pagination.php'; ?>
        </div>
    </section>
</main>
<!------------------------------------------------------------------->
<?php if (!isset($_SESSION['user'])) : ?>
    <?php require_once MODULES . 'login.php'; ?>
    <?php require_once MODULES . 'register.php'; ?>
<?php endif; ?>
<!------------------------------------------------------------------->
<?php require_once INCLUDES . 'footer.php'; ?>