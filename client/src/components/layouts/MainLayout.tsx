import React, {FC} from 'react';
import Navbar from "../Navbar/Navbar";
import SmallScreenNavbar from "../Navbar/SmallScreenNavbar";

interface MainLayoutProps {
    children?: React.ReactNode
}

const MainLayout: FC<MainLayoutProps> = ({children}) => {
    return (
        <div className="text-slate-800 dark:text-slate-400 bg-gray-100 dark:bg-slate-900 flex flex-col">
            <div className={"w-full border-b border-slate-500/30 sticky top-0 z-10 bg-white dark:backdrop-blur dark:bg-slate-900/90 shadow-lg dark:shadow-none shadow-gray-500/10"}>
                <div className="container mx-auto">
                        <Navbar className={"hidden lg:flex"}/>
                        <SmallScreenNavbar className={"flex lg:hidden"}/>
                </div>
            </div>
            <div className="container mx-auto min-h-screen relative">
                {children}
            </div>
        </div>

    );
};

export default MainLayout;