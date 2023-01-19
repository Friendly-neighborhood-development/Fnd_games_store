import React from 'react';
import {SimpleLayout} from "../components/layouts/SimpleLayout";

const Signup = () => {
    return (
        <SimpleLayout>
            <div className={"bg-gradient-to-tr from-pink-600 to-sky-600 opacity-10 absolute w-screen h-screen"}/>
            <div className={"mt-20"}>
                <div>Sign up</div>
            </div>
        </SimpleLayout>
    );
};

export default Signup