<?php

class accountController
{
    function __construct()
    {
    }
    //--------------------------------------------------------------------------------------------------
    function index()
    {
        if (!isset($_SESSION['user'])) {
            Redirect::to('home');
        }
        $toasts = "";
        $users = loadSetting();
        $toasts .= updateName($users->data[0]['id']);
        $toasts .= updateUser($users->data[0]['id']);
        $toasts .= updatePass($users->data[0]['id']);
        $toasts .= updateEmail($users->data[0]['id']);
        $toasts .= updateCarrer($users->data[0]['id']);
        $active = statusAccount();
        $data = [
            'title'           => 'Mi Cuenta',
            'id'              => $users->data[0]['id'],
            'rol'             => $users->data[0]['rol'],
            'name'            => $users->data[0]['name'],
            'lastname'        => $users->data[0]['lastname'],
            'user'            => $users->data[0]['user'],
            'pass'            => $users->data[0]['pass'],
            'pass_noencrypt'  => $users->data[0]['pass_noencrypt'],
            'email'           => $users->data[0]['email'],
            'carrer'          => $users->data[0]['carrer'],
            'token'           => $users->data[0]['token'],
            'active'          => $active,
            'toast'           => $toasts
        ];
        search();
        View::render('account', $data);
    }
    //--------------------------------------------------------------------------------------------------
    function recover_password()
    {
        $errorLogin = login();
        $errorRegister = register();
        $toasts = "";
        if (isset($_SESSION['user'])) {
            $users = loadSetting();
            $data = [
                'title'           => 'Recuperar Contraseña',
                'errorLogin'      => $errorLogin,
                'errorRegister'   => $errorRegister,
                'email'           => $users->data[0]['email'],
                'toast'           => $toasts
            ];
        }
        $toasts = recoverPassword(isset($users->data[0]['id']) ? $users->data[0]['id'] : 'void');
        $data = [
            'title'         => 'Recuperar Contraseña',
            'errorLogin'    => $errorLogin,
            'errorRegister' => $errorRegister,
            'toast'         => $toasts
        ];
        search();
        View::render('recoverPassword', $data);
    }
    //--------------------------------------------------------------------------------------------------
    function restore_password()
    {
        $request = statusRequestPassword();
        if ($request == 0) {
            Redirect::to('home');
        }
        $toasts = '';
        if (isset($_SESSION['user'])) {
            $users = loadSetting();
        }
        $toasts = restorePassword(isset($_SESSION['user']) ? $users->data[0]['email'] : $_GET['email']);
        $data = [
            'title' => 'Restablecer Contraseña',
            'toast' => $toasts
        ];
        search();
        View::render('restorePassword', $data);
    }
    //--------------------------------------------------------------------------------------------------
    function active()
    {
        if (!isset($_SESSION['user'])) {
            Redirect::to('home');
        }
        if (!isset($_GET['token'])) {
            Redirect::to('account');
        }
        $active = statusAccount();
        $data = [
            'title'  => 'Restablecer Contraseña',
            'token'  => $_GET['token'],
            'active' => $active
        ];
        if ($active == 0) {
            activeAccount($_SESSION['id'], 1);
        }
        search();
        View::render('active', $data);
    }

    function resend()
    {
        resendEmail($_GET['email'], $_GET['name'], $_GET['lastname'], $_GET['user'], $_GET['token']);
        Redirect::to('account');
    }
    //--------------------------------------------------------------------------------------------------
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
    function policiesprivacy()
    {
        Redirect::to('policiesprivacy');
    }
    function close()
    {
        close();
    }
    function back()
    {
        Redirect::to('account');
    }
    //--------------------------------------------------------------------------------------------------


}
