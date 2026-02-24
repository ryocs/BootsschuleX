'use client';
import { useEffect, useState } from 'react';
import { useParams, useRouter } from 'next/navigation';
import { Question, AnswerResult, Category } from '@/types/quiz';
import Button from '@/components/Button';

export default function QuizPage() {
  const { id } = useParams();
  const router = useRouter();
  const [question, setQuestion] = useState<Question | null>(null);
  const [selectedId, setSelectedId] = useState<number | null>(null);
  const [result, setResult] = useState<AnswerResult | null>(null);
  const [category, setCategory] = useState<Category | null>(null);

  const fetchQuestion = () => {
    fetch(`http://localhost:8080/api/categories/${id}/next-question`)
      .then((res) => res.json())
      .then((data) => {
        setQuestion(data);
        setSelectedId(null);
        setResult(null);
      });
  };

  const fetchCategories = () => {
    fetch('http://localhost:8080/api/categories')
      .then((res) => res.json())
      .then((data) => {
          data.forEach((cat: Category) => {
            if (cat.id === parseInt(id?.toString() || '', 10)) {
              setCategory(cat);
            }
          });
      });
  }


  useEffect(() => { 
    const fetchData = async () => {
      await fetchQuestion();
      await fetchCategories();
    };
    fetchData();
  }, [id]);

  const handleAnswer = async (optionId: number) => {
    if (result) return;
    setSelectedId(optionId);
    
    const res = await fetch(`http://localhost:8080/api/questions/${question?.id}/answer`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ selectedOptionId: optionId }),
    });
    const data = await res.json();
    setResult(data);
    await fetchCategories();
  };

  if (!question) return <div className="p-8">Lädt...</div>;

  if (question.message) {
    return (
      <div className="min-h-screen flex flex-col items-center justify-center p-8 bg-slate-50">
        <h2 className="text-2xl font-bold mb-4">{question.message}</h2>

        <Button label='Zurück zur Übersicht' onClick={() => router.push('/')}  />
      </div>
    );
  }

  return (
    <main className="min-h-screen bg-slate-50 p-8">
      <div className="max-w-2xl mx-auto mb-8 flex flex-col justify-center items-center">

        <Button onClick={() => router.push('/')} label='&larr; Zurück zur Übersicht' textOnly={true} className='self-start' />
        <h1 className="text-3xl font-bold text-slate-900 mt-4">{category?.name}</h1>
      </div>

      <div className="max-w-2xl mx-auto bg-white p-8 rounded-2xl shadow-lg">
        <h2 className="text-2xl font-bold mb-6">{question.text}</h2>
        
        <div className="space-y-4">
          {question.options.map((opt) => (

            <Button
              key={opt.id}
              onClick={() => handleAnswer(opt.id)}
              disabled={!!result}
              label={opt.text}
              textOnly={false}
              className={`w-full p-4 text-left rounded-xl border-2 transition-all cursor-pointer bg-transparent text-slate-600! hover:text-white! ${
                selectedId === opt.id 
                  ? (result?.isCorrect ? 'border-green-500 bg-green-50' : 'border-red-500 bg-red-50') 
                  : 'border-slate-100 hover:border-blue-400'
              } ${result && opt.id === result.correctOptionId ? 'border-green-500 bg-green-50' : ''}`}
            />
          ))}
        </div>

        {result && (
          <div className="mt-8 flex justify-between items-center">
            <p className={`font-bold ${result.isCorrect ? 'text-green-600' : 'text-red-600'}`}>
              {result.isCorrect ? 'Richtig! Gut gemacht!' : 'Leider falsch!'}
            </p>

            <Button label='Nächste Frage' onClick={fetchQuestion} className="bg-slate-900 text-white px-6 py-2 rounded-lg cursor-pointer" />
          </div>
        )}
      </div>

      {category && (
        <div className="max-w-2xl mx-auto bg-slate-200 rounded-full h-2.5 mt-8">
          <div 
            className="bg-blue-600 h-2.5 rounded-full transition-all duration-500" 
            style={{ width: `${(category.correctlyAnswered / category.totalQuestions) * 100}%` }}
          ></div>
        </div>
      )}

    </main>
  );
}