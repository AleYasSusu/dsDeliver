import React from "react";
import './style.css';
import { ReactComponent as Logo} from './logo.svg';


function Navbar()
    {
        return (
<nav className="main-navbar">
<div>
    <Logo />
    <a href="home" className="logo-text">DS Delivery</a>
    
    </div>
</nav>
        );
    }
    
export default Navbar;
