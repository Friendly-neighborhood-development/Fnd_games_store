import React, {FC, useEffect} from 'react';
import Header from "../Header/Header";
import SmHeader from "../Header/SmHeader";

interface MainLayoutProps {
    children?: React.ReactNode
}

const MainLayout: FC<MainLayoutProps> = ({children}) => {
    useEffect(() => {
        // если перейти по ссылке, то сразу убрать блокировку скролла
        // т.к. она остаётся при переходе по ссылке из меню для маленьких экранов
        // и убирается если кликнуть на страничку, на которой уже находится пользователь
        document.documentElement.style.overflow = ""
    }, [])
    return (
        <div className="text-slate-800 dark:text-slate-400 bg-gray-100 dark:bg-slate-900 flex flex-col min-h-screen">
                <Header/>
                <SmHeader/>
            <main className="container mx-auto relative">
                {children}
            </main>
        </div>

    );
};

export default MainLayout;