import React, {FC, useState} from 'react';
import {SimpleLayout} from "../components/layouts/SimpleLayout";
import {Link} from "react-router-dom";
import {PuzzlePieceIcon} from "@heroicons/react/24/outline";
import {Input} from "../components/UI/Input";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {signIn} from "../store/actions/authAction";
import {SecondaryButton} from "../components/UI/SecondaryButton";
import {ExclamationTriangleIcon} from "@heroicons/react/20/solid";
import {setDefaultAuth} from "../store/reducers/authSlice";

const Login: FC = () => {
    const [username, setUsername] = useState<string>("")
    const [password, setPassword] = useState<string>("")
    const {loading} = useAppSelector(state => state.auth)
    const dispatch = useAppDispatch()

    const formHandler = (e: React.SyntheticEvent) => {
        e.preventDefault()
        dispatch(signIn({username, password}))
    }

    return (
        <SimpleLayout>
            <div className={"pt-6 w-80 flex flex-col items-center"}>
                <Link to={"/"} className={"my-4"}>
                    <PuzzlePieceIcon className={"w-16 h-16 text-blue-600 dark:text-sky-500"}/>
                </Link>
                <div className={"text-xl dark:text-slate-200 mb-4"}>
                    Sign in to Games Store
                </div>
                {loading === "failed" &&
                    <div className={"text-red-500 mb-3 flex items-end space-x-2"}>
                        <ExclamationTriangleIcon className={"w-5 h-5"}/>
                        <span>Wrong username or password</span>
                    </div>}
                <form
                    className={"p-4 bg-gray-50 rounded-md w-full space-y-2 flex flex-col border-gray-500/30 border dark:bg-slate-700/50 dark:text-slate-300 dark:border-gray-500/50"}
                    onSubmit={formHandler}
                >
                    <Input
                        type={"text"}
                        label={"Username"}
                        className={"rounded-md py-1 my-2 border-gray-500/30 border dark:border-gray-500/50 dark:bg-slate-900"}
                        autoComplete={"on"}
                        value={username}
                        onChange={(e) => setUsername(e.currentTarget.value)}
                        onFocus={() => dispatch(setDefaultAuth())}
                    />
                    <Input
                        type={"password"}
                        label={"Password"}
                        className={"rounded-md py-1 my-2 border-gray-500/30 border dark:border-gray-500/50 dark:bg-slate-900"}
                        value={password}
                        onChange={(e) => setPassword(e.currentTarget.value)}
                        autoComplete={"password"}
                        onFocus={() => dispatch(setDefaultAuth())}
                    />
                    <SecondaryButton type={"submit"}>
                        Sign in
                    </SecondaryButton>
                </form>
                <div
                    className={"text-sm bg-white dark:bg-transparent p-4 rounded-lg border border-gray-500/30 dark:border-gray-500/50 w-full mt-4 flex justify-center"}>
                    <span className={"dark:text-slate-200"}>New to Games Store?</span>
                    <Link to={"/signup"} className={"ml-1 text-blue-600 dark:text-sky-500"}>
                        Create an account.
                    </Link>
                </div>
            </div>
        </SimpleLayout>
    );
};

export default Login

