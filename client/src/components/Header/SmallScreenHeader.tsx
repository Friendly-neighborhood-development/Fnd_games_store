import React, {FC, memo, useState} from 'react';
import {Bars3Icon, PuzzlePieceIcon, MagnifyingGlassIcon} from "@heroicons/react/24/outline";
import {Link} from "react-router-dom";
import ThemeSwitcher from "../UI/ThemeSwitcher";
import {XMarkIcon} from "@heroicons/react/20/solid";

const SmallScreenHeader: FC = memo(() => {
    const [modal, setModal] = useState(false)
    const setModalVisible = (visible: boolean) => {
        if (visible) {
            document.documentElement.style.overflow = "hidden"
            setModal(true)
        } else {
            document.documentElement.style.overflow = ""
            setModal(false)
        }
    }

    return (
        <header
            className={"w-full border-b border-slate-500/30 lg:hidden sticky top-0 z-10 bg-white dark:bg-slate-900/80 shadow-lg dark:shadow-none shadow-gray-500/10"}>
            <div className="container mx-auto">
                <div className={"w-full justify-between items-center flex  py-3"}>
                    <MagnifyingGlassIcon className={"w-6 h-6 dark:text-gray-100 cursor-pointer"}/>
                    <Link to={"/games"} className={"flex items-center"}>
                        <PuzzlePieceIcon className={"w-6 h-6 text-blue-500"}/>
                        <span className={"dark:text-gray-100 text-xl ml-1"}>Games Store</span>
                    </Link>
                    <Bars3Icon
                        className={"w-6 h-6 dark:text-gray-100 cursor-pointer"}
                        onClick={() => setModalVisible(!modal)}
                    />
                    {modal &&
                        <div className={"fixed z-50"}>
                            <div
                                className={"fixed inset-0 bg-black/20 backdrop-blur-sm dark:bg-slate-900/80 font-semibold dark:text-slate-300"}
                                aria-hidden="true"
                                onClick={() => setModalVisible(!modal)}
                            >
                                <div
                                    className={"fixed top-4 right-4 w-full max-w-xs bg-white dark:bg-slate-800 rounded-lg shadow-lg p-6 text-base"}
                                    onClick={(e) => e.stopPropagation()}
                                >
                                    <button
                                        className={"absolute right-5 top-5 w-8 h-8 flex items-center justify-center"}
                                        onClick={() => setModalVisible(!modal)}
                                    >
                                        <XMarkIcon className={"w-4 h-4"}/>
                                    </button>
                                    <ul className={"space-y-6"}>
                                        <li onClick={() => document.documentElement.style.overflow = ""}>
                                            <Link to={"/cart"}>Cart</Link>
                                        </li>
                                        <li onClick={() => document.documentElement.style.overflow = ""}>
                                            <Link to={"/notifications"}>Notifications</Link>
                                        </li>
                                        <li onClick={() => document.documentElement.style.overflow = ""}>
                                            <Link to={"/login"}>Login</Link>
                                        </li>
                                    </ul>
                                    <div
                                        className={"pt-6 mt-6 border-t-slate-200 dark:border-t-slate-200/10 border-t flex items-center justify-between text-slate-700 dark:text-slate-400 font-normal"}>
                                        Switch theme
                                        <ThemeSwitcher/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    }
                </div>
            </div>
        </header>

    );
});

export default SmallScreenHeader;