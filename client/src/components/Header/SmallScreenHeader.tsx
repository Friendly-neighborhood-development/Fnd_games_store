import React, {FC, memo} from 'react';
import {Bars3Icon, PuzzlePieceIcon, MagnifyingGlassIcon} from "@heroicons/react/24/outline";
import {Link} from "react-router-dom";
import ThemeSwitcher from "../UI/ThemeSwitcher";

const SmallScreenHeader: FC = memo(() => {
    return (
        <header
            className={"w-full border-b border-slate-500/30 lg:hidden sticky top-0 z-10 bg-white dark:bg-slate-900/80 shadow-lg dark:shadow-none shadow-gray-500/10"}>
            <div className="container mx-auto">
                <div className={"w-full justify-between items-center flex  py-3"}>
                    <MagnifyingGlassIcon className={"w-6 h-6 dark:text-gray-100"}/>
                    <Link to={"/games"} className={"flex items-center"}>
                        <PuzzlePieceIcon className={"w-6 h-6 text-blue-500"}/>
                        <span className={"dark:text-gray-100 text-xl ml-1"}>Games Store</span>
                    </Link>
                    <Bars3Icon className={"w-6 h-6 dark:text-gray-100"}/>
                    <div className={"fixed z-50"}>
                        <div
                            className={"fixed inset-0 bg-black/20 backdrop-blur-sm dark:bg-slate-900/80 font-semibold dark:text-slate-300"}
                            aria-hidden="true">
                            <div
                                className={"fixed top-4 right-4 w-full max-w-xs bg-white dark:bg-slate-800 rounded-lg shadow-lg p-6 text-base"}>
                                <ul className={"space-y-6"}>
                                    <li><Link to={"/notifications"}>Notifications</Link></li>
                                    <li><Link to={"/cart"}>Cart</Link></li>
                                    <li><Link to={"/login"}>Login</Link></li>
                                </ul>
                                <div
                                    className={"pt-6 mt-6 border-t-slate-200 dark:border-t-slate-200/10 border-t flex items-center justify-between text-slate-700 dark:text-slate-400 font-normal"}>
                                    Switch theme
                                    <ThemeSwitcher/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>

    );
});

export default SmallScreenHeader;