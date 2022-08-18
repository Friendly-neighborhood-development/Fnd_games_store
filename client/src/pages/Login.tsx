import React from 'react';
import NotLoginLayout from "../components/layouts/NotLoginLayout";
import {Link} from "react-router-dom";
import {PuzzleIcon} from "@heroicons/react/outline";
import Input from "../components/UI/Input";
import Button from "../components/UI/Button";

const Login = () => {
    const formHandler = (e: React.SyntheticEvent) => {
        e.preventDefault()
    }
    return (
        <NotLoginLayout>
            <div className={"pt-6 w-80 flex flex-col items-center"}>
                <Link to={"/games"} className={"my-4"}>
                    <PuzzleIcon className={"w-16 h-16 text-blue-600 dark:text-sky-500"}/>
                </Link>
                <h1 className={"text-xl dark:text-slate-200 mb-4"}>
                    Sign in to Games Store
                </h1>
                <form
                    className={"p-4 bg-gray-50 dark:bg-slate-700/50 dark:text-slate-300 rounded-md w-full space-y-2 flex flex-col border-gray-500/30 dark:border-gray-500/50 border"}
                    onSubmit={formHandler}
                >
                    <Input
                        type={"email"}
                        label={"Email"}
                        className={"rounded-md py-1 my-2 border-gray-500/30 dark:border-gray-500/50 border dark:bg-slate-900"}
                        autoComplete={"username"}
                    />
                    <Input
                        type={"password"}
                        label={"Password"}
                        className={"rounded-md py-1 my-2 border-gray-500/30 dark:border-gray-500/50 border dark:bg-slate-900"}
                    />
                    <Button
                        className={"bg-green-500 dark:bg-green-700 hover:bg-green-600 dark:hover:bg-green-600 w-full text-white"}
                        type={"submit"}
                        // value={"Submit"}
                    >
                        Sign in
                    </Button>
                </form>
                <div className={"text-sm bg-white dark:bg-transparent p-4 rounded-lg border border-gray-500/30 dark:border-gray-500/50 w-full mt-4 flex justify-center"}>
                    <span className={"dark:text-slate-200"}>New to Games Store?</span>
                    <Link to={"/register"} className={"ml-1 text-blue-600 dark:text-sky-500"}>
                        Create an account .
                    </Link>
                </div>
            </div>
        </NotLoginLayout>
    );
};

export default Login;