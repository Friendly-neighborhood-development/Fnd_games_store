import React from 'react';
import NotLoginLayout from "../components/layouts/NotLoginLayout";
import {Link} from "react-router-dom";
import {PuzzleIcon} from "@heroicons/react/outline";
import Input from "../components/UI/Input";
import Button from "../components/UI/Button";

const Login = () => {
    return (
        <NotLoginLayout>
            <div className={"flex justify-center"}>
                <div className={"pt-6 flex flex-col items-center w-80"}>
                    <Link to={"/games"} className={"my-4"}>
                        <PuzzleIcon className={"w-16 h-16 text-sky-500"}/>
                    </Link>
                    <h1 className={"text-xl text-slate-300 mb-4"}>
                        Sign in to Games Store
                    </h1>
                    <form
                        className={"p-4 dark:bg-slate-700/50 dark:text-slate-300 rounded-md w-full space-y-2 flex flex-col border-gray-500/30 border"}>
                        <Input
                            type={"email"}
                            label={"Email"}
                            className={"rounded p-1 my-2 border-gray-500/50 border"}
                        />
                        <Input
                            type={"password"}
                            label={"Password"}
                            className={"rounded p-1 my-2 border-gray-500/50 border"}
                        />
                        <Button className={"dark:bg-green-700 dark:hover:bg-green-600 w-full dark:text-white"}>
                            Sign in
                        </Button>
                    </form>
                    <div className={"text-sm p-4 rounded-lg border border-gray-500/50 w-full mt-4 flex justify-center"}>
                        New to Games Store?
                        <Link to={"/register"} className={"ml-1 text-sky-500"}>
                            Create an account
                        </Link>
                    </div>
                </div>
            </div>

        </NotLoginLayout>

    );
};

export default Login;