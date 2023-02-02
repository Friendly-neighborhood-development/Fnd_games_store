import React, { FC, useEffect } from 'react';
import { Header } from '../Header/Header';
import { SmHeader } from '../Header/SmHeader';
import { Footer } from '../Footer';

interface MainLayoutProps {
    children?: React.ReactNode;
}

export const MainLayout: FC<MainLayoutProps> = ({ children }) => {
    useEffect(() => {
        // если перейти по ссылке, то сразу убрать блокировку скролла
        // т.к. она остаётся при переходе по ссылке из меню для маленьких экранов
        // и убирается если кликнуть на страничку, на которой уже находится пользователь
        document.documentElement.style.overflow = '';
    }, []);
    return (
        <div className="text-slate-900 bg-gray-100 flex flex-col flex-1 dark:text-slate-200 dark:bg-slate-900">
            <Header />
            <SmHeader />
            <main className="container mx-auto">
                <div className="flex flex-col justify-between flex-1">
                    <div>{children}</div>
                    <Footer />
                </div>
            </main>
        </div>
    );
};
