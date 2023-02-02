import { ITheme } from '../models/ITheme';
import { useState } from 'react';
import { themes } from '../constants/themes';

export const useSwitchTheme = () => {
    const [selectedTheme, setSelectedTheme] = useState(themes[0]);
    const switchTheme = (theme: ITheme) => {
        switch (theme.title) {
            case 'light':
                localStorage.theme = 'light';
                document.documentElement.classList.add('light');
                document.documentElement.classList.remove('dark');
                document.documentElement.style.backgroundColor = '#f3f4f6';
                setSelectedTheme(themes[0]);
                break;
            case 'dark':
                localStorage.theme = 'dark';
                document.documentElement.classList.add('dark');
                document.documentElement.classList.remove('light');
                document.documentElement.style.backgroundColor = '#0f172a';
                setSelectedTheme(themes[1]);
                break;
            default:
                localStorage.theme = 'system';
                if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
                    document.documentElement.classList.add('dark');
                    document.documentElement.classList.remove('light');
                    document.documentElement.style.backgroundColor = '#0f172a';
                    setSelectedTheme(themes[2]);
                } else {
                    document.documentElement.classList.add('light');
                    document.documentElement.classList.remove('dark');
                    document.documentElement.style.backgroundColor = '#f3f4f6';
                    setSelectedTheme(themes[2]);
                }
        }
    };

    return { selectedTheme, setSelectedTheme: switchTheme };
};
