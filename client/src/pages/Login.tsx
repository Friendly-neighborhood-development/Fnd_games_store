import React, {useState} from 'react';
import NotLoginLayout from "../components/layouts/NotLoginLayout";
import {Link} from "react-router-dom";
import {PuzzlePieceIcon} from "@heroicons/react/24/outline";
import Input from "../components/UI/Input";
import Button from "../components/UI/Button";
import {useAppDispatch, useAppSelector} from "../hooks/redux";

const Login = () => {
    const [username, setUsername] = useState<string>("")
    const [password, setPassword] = useState<string>("")
    const dispatch = useAppDispatch()
    const {loading, error} = useAppSelector(state => state.auth)

    const formHandler = (e: React.SyntheticEvent) => {
        e.preventDefault()
    }

    const submitHandler = () => {

    }

    return (
        <NotLoginLayout>
            <div className={"pt-6 w-80 flex flex-col items-center"}>
                <Link to={"/games"} className={"my-4"}>
                    <PuzzlePieceIcon className={"w-16 h-16 text-blue-600 dark:text-sky-500"}/>
                </Link>
                <h1 className={"text-xl dark:text-slate-200 mb-4"}>
                    Sign in to Games Store
                </h1>
                <form
                    className={"p-4 bg-gray-50 dark:bg-slate-700/50 dark:text-slate-300 rounded-md w-full space-y-2 flex flex-col border-gray-500/30 dark:border-gray-500/50 border"}
                    onSubmit={formHandler}
                >
                    <Input
                        type={"text"}
                        label={"Username"}
                        className={"rounded-md py-1 my-2 border-gray-500/30 dark:border-gray-500/50 border dark:bg-slate-900"}
                        autoComplete={"username"}
                        value={username}
                        onChange={(e) => setUsername(e.currentTarget.value)}
                    />
                    <Input
                        type={"password"}
                        label={"Password"}
                        className={"rounded-md py-1 my-2 border-gray-500/30 dark:border-gray-500/50 border dark:bg-slate-900"}
                        value={password}
                        onChange={(e) => setPassword(e.currentTarget.value)}
                    />
                    <Button
                        className={"bg-green-500 dark:bg-green-700 hover:bg-green-600 dark:hover:bg-green-600 w-full text-white"}
                        type={"submit"}
                        onClick={submitHandler}
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