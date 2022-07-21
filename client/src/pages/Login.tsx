import React from 'react';
import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";

const Login = () => {
    return (
        <div className="container">
            <div className={"page"}>
                <Sidebar/>
                <div className="main-wrapper">
                    <Navbar/>
                    Login
                </div>
            </div>
        </div>
    );
};

export default Login;