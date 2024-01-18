import React from "react";

import styles from "../../css/styles.css";
import Footer from "./Footer";
import { Link } from 'react-router-dom';

function Layout() {
  return (
    <>
     <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#!">BLOG</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li className="nav-item"><a className="nav-link" href="#">Home</a></li>
                        <li className="nav-item"><a className="nav-link" href="#!">About</a></li>
                        <li className="nav-item"><Link to="/signin" className="nav-link">Se connecter</Link></li>
                        <li className="nav-item"><a className="nav-link active" aria-current="page" href="#">Blog</a>
                        </li>

                    </ul>
                </div>
            </div>
     </nav>


    </>
  );
}

export default Layout;
