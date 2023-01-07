import React, {FC, memo} from 'react';
import {ArrowRightOnRectangleIcon, PuzzlePieceIcon, ShoppingCartIcon, UserIcon} from "@heroicons/react/24/outline";
import {Link} from "react-router-dom";
import {HeaderIcon} from "./HeaderIcon";
import ThemeSwitcher from "../ThemeSwitcher";
import {Search} from "../UI/Search";
import {useAppDispatch, useAppSelector} from "../../hooks/redux";
import {signOut} from "../../store/reducers/authSlice";

export const Header: FC = memo(() => {
    const dispatch = useAppDispatch()
    const {isAuth} = useAppSelector(state => state.auth)
    const logoutHandler = () => {
        dispatch(signOut())
    }
    return (
        <header
            className={"w-full border-b border-slate-500/30 hidden sticky lg:block top-0 z-10 bg-white shadow-lg shadow-gray-500/10 dark:backdrop-blur dark:bg-slate-900/80 dark:shadow-none"}>
            <div className="container mx-auto">
                <div className={"w-full justify-between items-center py-4 flex"}>
                    <Link to={"/"} className={"mr-4 flex items-center"}>
                        <PuzzlePieceIcon className={"w-10 h-10 text-blue-600 dark:text-sky-500"}/>
                        <span className={"ml-2  md:text-3xl text-xl dark:text-white"}>Games Store</span>
                    </Link>
                    <nav className={"flex items-center space-x-4 relative"}>
                        <Search placeholder={"Search in the store"}/>
                        <ThemeSwitcher/>
                        <HeaderIcon link={"/cart"}>
                            <ShoppingCartIcon className={"text-slate-500 w-3/5 h-3/5 dark:text-slate-300"}/>
                        </HeaderIcon>
                        {isAuth ?
                            <HeaderIcon link={"/login"} onClick={logoutHandler}>
                                <ArrowRightOnRectangleIcon
                                    className={"text-slate-500 w-3/5 h-3/5 dark:text-slate-300"}/>
                            </HeaderIcon>
                            :
                            <HeaderIcon link={"/login"}>
                                <UserIcon
                                    className={"text-slate-500 w-3/5 h-3/5 dark:text-slate-300"}/>
                            </HeaderIcon>
                        }
                    </nav>
                </div>
            </div>
        </header>
    );
})

