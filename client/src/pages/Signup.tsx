import React, {useEffect, useState} from 'react';
import {SimpleLayout} from "../components/layouts/SimpleLayout";
import {ChevronRightIcon, PuzzlePieceIcon} from "@heroicons/react/24/outline";
import {SecondaryButton} from "../components/UI/SecondaryButton";
import {Input} from "../components/UI/Input";
import {Link, redirect, useNavigate} from "react-router-dom";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {signUp} from "../store/actions/authAction";
import {setDefaultAuth} from "../store/reducers/authSlice";

const Signup = () => {
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [email, setEmail] = useState("")
    const dispatch = useAppDispatch()
    const {loading} = useAppSelector(state => state.auth)
    const formHandler = (e: React.SyntheticEvent) => {
        e.preventDefault()
        dispatch(signUp({username, password, email}))
    }
    const navigate = useNavigate()
    useEffect(() => {
        if(loading === "succeeded"){
            dispatch(setDefaultAuth())
            return navigate("/login")
        }
    }, [loading])

    return (
        <SimpleLayout>
            <div className={"pt-6 w-80 flex flex-col items-center"}>
                <Link to={"/"} className={"my-4"}>
                    <PuzzlePieceIcon className={"w-16 h-16 text-blue-600 dark:text-sky-500"}/>
                </Link>
                <div className={"text-xl dark:text-slate-200 mb-4"}>
                    Sign up to Games Store
                </div>
                <form
                    className={"p-4 bg-gray-50 rounded-md w-full space-y-2 flex flex-col border-gray-500/30 border dark:bg-slate-700/50 dark:text-slate-300 dark:border-gray-500/50"}
                    onSubmit={formHandler}
                >
                    <Input
                        value={email}
                        onChange={(e) => setEmail(e.currentTarget.value)}
                        required={true}
                        type={"email"}
                        label={"Email"}
                        className={"rounded-md py-1 my-2 border-gray-500/30 border dark:border-gray-500/50 dark:bg-slate-900"}
                        autoComplete={"on"}
                    />
                    <Input
                        value={username}
                        onChange={(e) => setUsername(e.currentTarget.value)}
                        required={true}
                        type={"text"}
                        label={"Username"}
                        className={"rounded-md py-1 my-2 border-gray-500/30 border dark:border-gray-500/50 dark:bg-slate-900"}
                        autoComplete={"no"}
                    />
                    <Input
                        value={password}
                        onChange={(e) => setPassword(e.currentTarget.value)}
                        required={true}
                        type={"password"}
                        label={"Password"}
                        className={"rounded-md py-1 my-2 border-gray-500/30 border dark:border-gray-500/50 dark:bg-slate-900"}
                        autoComplete={"new-password"}
                    />
                    <SecondaryButton type={"submit"}>
                        Sign up
                    </SecondaryButton>
                </form>
                <div
                    className={"text-sm bg-white dark:bg-transparent p-4 rounded-lg border border-gray-500/30 dark:border-gray-500/50 w-full mt-4 flex justify-center"}>
                    <span className={"dark:text-slate-200"}>Already have an account?</span>
                    <Link to={"/login"} className={"ml-1 text-blue-600 dark:text-sky-500 flex items-center"}>
                        Sign in <ChevronRightIcon className={"w-4 h-4"}/>
                    </Link>
                </div>
            </div>
        </SimpleLayout>
    );
};

export default Signup