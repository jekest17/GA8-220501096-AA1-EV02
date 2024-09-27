<%-- 
    Document   : info
    Created on : 10/09/2024, 4:01:52 p. m.
    Author     : jjer1
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CyberShield AI - Servicios de Ciberseguridad</title>
    
    <!-- Estilos CSS embebidos -->
    <style>
        /* Reset básico y estilos globales */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Roboto', sans-serif;
            line-height: 1.6;
            background-color: #121212;
            color: #fff;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        /* Estilos de la barra de navegación */
        .navbar {
            background-color: #1f1f1f;
            color: #fff;
            padding: 15px 0;
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
            transition: background-color 0.3s ease;
        }

        .navbar.scrolled {
            background-color: rgba(31, 31, 31, 0.9);
        }

        .navbar .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .nav-links {
            list-style-type: none;
            display: flex;
        }

        .nav-links li {
            margin-right: 20px;
        }

        .nav-links a {
            color: #fff;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .nav-links a:hover {
            color: #007bff;
        }

        .logo {
            font-size: 1.5rem;
        }

        /* Estilos del héroe */
        .hero {
            background: url('images/fondo.jpg') no-repeat center center/cover;
            color: #fff;
            padding: 100px 0;
            text-align: left;
            position: relative;
        }

        .hero-content {
            max-width: 600px;
        }

        .hero-title {
            font-size: 3rem;
            margin-bottom: 20px;
            animation: fadeInUp 1s ease;
        }

        .hero-subtitle {
            font-size: 1.5rem;
            animation: fadeInUp 1s ease 0.5s;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            margin-top: 20px;
            animation: fadeInUp 1s ease 1s;
        }

        .btn-primary {
            margin-right: 10px;
        }

        .btn-secondary {
            background-color: #6c757d;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .btn-secondary:hover {
            background-color: #5a6268;
        }

        /* Estilos de secciones */
        .section-title {
            font-size: 2.5rem;
            margin-bottom: 30px;
            text-align: center;
            animation: fadeInUp 1s ease;
        }

        .section-desc {
            text-align: center;
            margin-bottom: 60px;
            animation: fadeInUp 1s ease 0.5s;
        }

        /* Estilos de servicios */
        .services {
            padding: 80px 0;
            background-color: #1f1f1f;
        }

        .service-cards {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .service-card {
            background-color: #2c2c2c;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 45%;
            margin-bottom: 20px;
            padding: 20px;
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .service-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }

        .service-icon {
            max-width: 100px;
            margin-bottom: 20px;
        }

        .service-title {
            font-size: 1.5rem;
            margin-bottom: 10px;
        }

        .service-desc {
            font-size: 1rem;
            margin-bottom: 20px;
        }

        .service-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .service-link:hover {
            background-color: #0056b3;
        }

        /* Estilos de contacto */
        .contact {
            padding: 80px 0;
        }

        .contact-form {
            max-width: 600px;
            margin: 0 auto;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #ccc;
        }

        input, textarea {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #2c2c2c;
            color: #fff;
        }

        input[type="text"], input[type="email"] {
            height: 40px;
        }

        textarea {
            resize: vertical;
        }

        button[type="submit"] {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Estilos del pie de página */
        .footer {
            background-color: #1f1f1f;
            padding: 20px 0;
            text-align: center;
        }

        .footer-text {
            color: #ccc;
        }

        /* Animaciones */
        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="container">
                <h1 class="logoinfo">CyberShield AI</h1>
                <ul class="nav-links">
                    <li><a href="#home">Inicio</a></li>
                    <li><a href="#services">Servicios</a></li>
                    <li><a href="#about">Acerca de</a></li>
                    <li><a href="#contact">Contacto</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <section id="home" class="hero">
        <div class="container">
            <div class="hero-content">
                <h1 class="hero-title">Protege tu negocio con CyberShield AI</h1>
                <p class="hero-subtitle">Soluciones avanzadas en ciberseguridad para empresas.</p>
                <a href="#services" class="btn btn-primary">Ver Servicios</a>
                <a href="#demo" class="btn btn-secondary">Solicitar una Demo</a>
            </div>
        </div>
    </section>

    <section id="services" class="services">
        <div class="container">
            <h2 class="section-title">Nuestros Servicios</h2>
            <div class="service-cards">
                <div class="service-card">
                    <img src="images/icon1.png" alt="Monitoreo de Amenazas" class="service-icon">
                    <h3 class="service-title">Monitoreo de Amenazas</h3>
                    <p class="service-desc">Detectamos y respondemos a las amenazas cibernéticas en tiempo real para proteger tu empresa.</p>
                    <a href="#" class="service-link">Monitoreo de Amenazas</a>
                </div>
                <div class="service-card">
                    <img src="images/icon2.png" alt="Análisis de Vulnerabilidades" class="service-icon">
                    <h3 class="service-title">Análisis de Vulnerabilidades</h3>
                    <p class="service-desc">Identificamos y corregimos las vulnerabilidades de seguridad en tu infraestructura digital.</p>
                    <a href="#" class="service-link">Análisis de Vulnerabilidades</a>
                </div>
                <div class="service-card">
                    <img src="images/icon3.png" alt="Gestión de Identidad y Acceso" class="service-icon">
                    <h3 class="service-title">Gestión de Identidad y Acceso</h3>
                    <p class="service-desc">Controlamos y aseguramos el acceso a los sistemas y datos críticos de tu organización.</p>
                    <a href="#" class="service-link">Gestión de Identidad y Acceso</a>
                </div>
                <div class="service-card">
                    <img src="images/icon1.png" alt="Seguridad en la Nube" class="service-icon">
                    <h3 class="service-title">Seguridad en la Nube</h3>
                    <p class="service-desc">Protegemos tus datos y aplicaciones en entornos de nube pública y privada.</p>
                    <a href="#" class="service-link">Seguridad en la Nube</a>
                </div>
            </div>
        </div>
    </section>

    <section id="about" class="about">
        <div class="container">
            <h2 class="section-title">Acerca de Nosotros</h2>
            <p class="section-desc">CyberShield AI es una empresa dedicada a ofrecer soluciones avanzadas en ciberseguridad para empresas de todos los tamaños. Con un equipo de expertos en seguridad digital, estamos comprometidos a proteger tu negocio contra las amenazas cibernéticas.</p>
        </div>
    </section>

    <section id="contact" class="contact">
        <div class="container">
            <h2 class="section-title">Contacto</h2>
            <form id="contact-form" class="contact-form">
                <div class="form-group">
                    <label for="name">Nombre:</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="email">Correo Electrónico:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="message">Mensaje:</label>
                    <textarea id="message" name="message" rows="5" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Enviar Mensaje</button>
            </form>
        </div>
    </section>

    <footer class="footer">
        <div class="container">
            <p class="footer-text">&copy; 2024 CyberShield AI. Todos los derechos reservados.</p>
        </div>
    </footer>

    <!-- JavaScript embebido -->
    <script>
        // Cambiar el color de fondo de la barra de navegación al hacer scroll
        window.addEventListener('scroll', function() {
            const navbar = document.querySelector('.navbar');
            navbar.classList.toggle('scrolled', window.scrollY > 0);
        });
    </script>
</body>
</html>
