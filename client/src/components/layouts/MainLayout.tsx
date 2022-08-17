import React, {FC} from 'react';
import Navbar from "../Navbar/Navbar";
import SmallScreenNavbar from "../Navbar/SmallScreenNavbar";

interface MainLayoutProps {
    children?: React.ReactNode
}

const MainLayout: FC<MainLayoutProps> = ({children}) => {
    return (
        <div className="text-slate-800 dark:text-slate-400 bg-gray-100 dark:bg-slate-900 flex">
            <div className="container mx-auto min-h-screen">
                {/*<Sidebar/>*/}
                <div className="flex flex-col items-center pt-4 lg:pt-6">
                    <Navbar className={"hidden lg:flex"}/>
                    <SmallScreenNavbar className={"flex lg:hidden"}/>
                    {children}
                </div>
            </div>
        </div>

    );
};

export default MainLayout;