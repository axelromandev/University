<?php

class homeController
{
    function __construct()
    {
    }

    function index()
    {
        $errorLogin    = login();
        $postsLikes    = getPostLikes(3);
        $postsViews    = getPostViews(8);
        $data = [
            'title'         => 'Bienvenido',
            'errorLogin'    => $errorLogin,
            'postsLikes'    => $postsLikes,
            'postsViews'    => $postsViews
        ];
        search();
        View::render('main', $data);
    }

    function home()
    {
        Redirect::to('home');
    }
    function publications()
    {
        Redirect::to('publications');
    }
    function myarticle()
    {
        Redirect::to('myarticle');
    }
    function account()
    {
        Redirect::to('account');
    }
    function close()
    {
        close();
    }
}
