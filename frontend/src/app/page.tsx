'use client';
import { useEffect, useState } from 'react';
import Link from 'next/link';
import { Category } from '@/types/quiz';
import Button from '@/components/Button';

export default function Home() {
  const [categories, setCategories] = useState<Category[]>([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/categories')
      .then((res) => res.json())
      .then((data) => setCategories(data));
  }, []);

  const resetProgress = () => {
    fetch('http://localhost:8080/api/questions/resetall', { method: 'POST' })
      .then(() => {
        return fetch('http://localhost:8080/api/categories');
      })
      .then((res) => res.json())
      .then((data) => setCategories(data));
  }

  return (
    <main className="min-h-screen bg-slate-50 p-8">
      <div className="max-w-4xl mx-auto">
        <h1 className="text-3xl font-bold text-slate-900 mb-8">BootsschuleX - Quiz Übersicht</h1>
        
        <div className="grid gap-6 md:grid-cols-2">
          {categories.map((cat) => (
            <div key={cat.id} className="bg-white p-6 rounded-xl shadow-sm border border-slate-200">
              <h2 className="text-xl font-semibold mb-2">{cat.name}</h2>
              <p className="text-slate-600 text-sm mb-4">{cat.progressText}</p>
              
              <div className="w-full bg-slate-200 rounded-full h-2.5 mb-6">
                <div 
                  className="bg-blue-600 h-2.5 rounded-full transition-all duration-500" 
                  style={{ width: `${(cat.correctlyAnswered / cat.totalQuestions) * 100}%` }}
                ></div>
              </div>

              <Button href={`/quiz/${cat.id}`} label='Kategorie starten' />
      
            </div>
          ))}
        </div>
      </div>

      <button className="absolute bottom-8 right-8 bg-transparent border-red-600 border-1 cursor-pointer text-red-600 px-4 py-2 rounded-lg font-medium hover:bg-red-600 hover:text-white transition-colors" onClick={resetProgress}>Alle Fortschritte zurücksetzen</button>
    </main>
  );
}