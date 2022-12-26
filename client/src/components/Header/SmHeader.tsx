import React, {FC, memo, useState} from 'react';
import {
    Bars3Icon,
    PuzzlePieceIcon,
    MagnifyingGlassIcon,
    ShoppingCartIcon,
    BellIcon,
    UserIcon
} from "@heroicons/react/24/outline";
import {Link} from "react-router-dom";
import ThemeSwitcher from "../ThemeSwitcher";
import {XMarkIcon} from "@heroicons/react/20/solid";
import SmHeaderLink from "./SmHeaderLink";

const SmHeader: FC = memo(() => {
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
        <>
            <header
                className={"w-full border-b border-slate-500/30 lg:hidden sticky top-0 z-10 bg-white shadow-gray-500/10 backdrop-blur shadow-lg dark:bg-slate-900/80 dark:shadow-none"}>
                <div className="container mx-auto">
                    <div className={"w-full justify-between items-center flex  py-3"}>
                        <MagnifyingGlassIcon className={"w-6 h-6 cursor-pointer dark:text-gray-100"}/>
                        <Link to={"/games"} className={"flex items-center"}>
                            <PuzzlePieceIcon className={"w-6 h-6 text-blue-600"}/>
                            <span className={"text-xl ml-1 dark:text-gray-100"}>Games Store</span>
                        </Link>
                        <Bars3Icon
                            className={"w-6 h-6 cursor-pointer dark:text-gray-100"}
                            onClick={() => setModalVisible(!modal)}
                        />
                    </div>
                </div>
            </header>
            {modal &&
                <div className={"fixed z-50 inset-0"}>
                    <div
                        className={"fixed inset-0 bg-black/20 backdrop-blur-sm  font-semibold dark:bg-slate-900/80 dark:text-slate-300"}
                        onClick={() => setModalVisible(!modal)}
                    >
                        <div
                            className={"fixed top-4 right-4 w-full max-w-xs bg-white rounded-lg shadow-lg p-6 text-base dark:bg-slate-800"}
                            onClick={(e) => e.stopPropagation()}
                        >
                            <button
                                className={"absolute right-5 top-5 w-8 h-8 flex items-center justify-center"}
                                onClick={() => setModalVisible(!modal)}
                            >
                                <XMarkIcon className={"w-4 h-4"}/>
                            </button>
                            <ul className={"space-y-6"}>
                                <li><SmHeaderLink href={"/cart"} title={"Cart"} Icon={ShoppingCartIcon}/></li>
                                <li><SmHeaderLink href={"/notifications"} title={"Notifications"} Icon={BellIcon}/></li>
                                <li><SmHeaderLink href={"/login"} title={"Login"} Icon={UserIcon}/></li>
                            </ul>
                            <div
                                className={"pt-6 mt-6 border-t-slate-200 border-t flex items-center justify-between text-slate-700 font-normal dark:text-slate-400 dark:border-t-slate-200/10"}>
                                Switch theme
                                <ThemeSwitcher/>
                            </div>
                        </div>
                    </div>
                </div>
            }
        </>
    );
});

export default SmHeader;