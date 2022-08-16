import React, {FC} from 'react';
import Sidebar from "../Sidebar";
import Navbar from "../Navbar";

interface MainLayoutProps {
    children?: React.ReactNode
}

const MainLayout: FC<MainLayoutProps> = ({children}) => {
    return (
        <div className="text-slate-800 dark:text-slate-400 bg-gray-100 dark:bg-slate-900 flex">
            <div className="container mx-auto min-h-screen">
                {/*<Sidebar/>*/}
                <div className="flex flex-col items-center pt-4 lg:pt-6">
                    <Navbar/>
                    {children}
                </div>
            </div>
        </div>

    );
};

export default MainLayout;